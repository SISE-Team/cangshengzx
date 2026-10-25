package local.cangsheng.core.event;

import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import com.mojang.brigadier.exceptions.CommandSyntaxException;
import local.cangsheng.Cangsheng;
import local.cangsheng.core.registry.CangshengDataRegistries;
import net.minecraft.core.Holder;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.gametest.framework.GameTestHelper;
import net.minecraft.gametest.framework.GameTestInstance;
import net.minecraft.gametest.framework.TestData;
import net.minecraft.gametest.framework.TestEnvironmentDefinition;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.neoforged.neoforge.event.RegisterGameTestsEvent;

import java.util.List;

/** Adds a smoke test proving the mod item registry is populated in GameTest. */
public final class CangshengGameTests {
    private CangshengGameTests() {}

    public static void register(RegisterGameTestsEvent event) {
        Holder<TestEnvironmentDefinition<?>> environment = event.registerEnvironment(
                Identifier.fromNamespaceAndPath(Cangsheng.MOD_ID, "default"),
                new TestEnvironmentDefinition.AllOf(List.of()));
        TestData<Holder<TestEnvironmentDefinition<?>>> testData = new TestData<>(
                environment, Identifier.withDefaultNamespace("empty"), 1, 1, true);
        event.registerTest(Identifier.fromNamespaceAndPath(Cangsheng.MOD_ID, "registry_smoke"),
                new RegistrySmokeTest(testData));
    }

    public static final class RegistrySmokeTest extends GameTestInstance {
        public static final MapCodec<RegistrySmokeTest> CODEC = RecordCodecBuilder.mapCodec(instance -> instance.group(
                TestData.CODEC.forGetter(RegistrySmokeTest::testData)
        ).apply(instance, RegistrySmokeTest::new));

        public RegistrySmokeTest(TestData<Holder<TestEnvironmentDefinition<?>>> testData) {
            super(testData);
        }

        @Override
        public void run(GameTestHelper helper) {
            boolean registered = BuiltInRegistries.ITEM.getOptional(
                    Identifier.fromNamespaceAndPath(Cangsheng.MOD_ID, "huanshang_token")).isPresent();
            helper.assertTrue(registered, Component.literal("Missing cangsheng:huanshang_token"));
            ResourceKey<local.cangsheng.core.datapack.RealmDefinition> realmKey = ResourceKey.create(
                    CangshengDataRegistries.REALMS,
                    Identifier.fromNamespaceAndPath(Cangsheng.MOD_ID, "refining_qi"));
            boolean realmLoaded = helper.getLevel().registryAccess()
                    .lookupOrThrow(CangshengDataRegistries.REALMS).get(realmKey).isPresent();
            helper.assertTrue(realmLoaded, Component.literal("Missing cangsheng:refining_qi realm data"));
            var registryAccess = helper.getLevel().registryAccess();
            helper.assertTrue(registryAccess.lookupOrThrow(CangshengDataRegistries.REALMS).listElements().count() == 10,
                    Component.literal("Expected ten realm entries"));
            helper.assertTrue(registryAccess.lookupOrThrow(CangshengDataRegistries.SECTS).listElements().count() == 6,
                    Component.literal("Expected six sect entries"));
            helper.assertTrue(registryAccess.lookupOrThrow(CangshengDataRegistries.RESOURCES).listElements().count() == 11,
                    Component.literal("Expected eleven resource entries"));
            helper.assertTrue(registryAccess.lookupOrThrow(CangshengDataRegistries.SKILLS).listElements().count() == 2,
                    Component.literal("Expected two sample skill entries"));
            boolean commandRegistered = helper.getLevel().getServer().getCommands().getDispatcher().getRoot()
                    .getChild("cangsheng") != null;
            helper.assertTrue(commandRegistered, Component.literal("Missing /cangsheng command root"));
            try {
                int commandResult = helper.getLevel().getServer().getCommands().getDispatcher()
                        .execute("cangsheng debug profile", helper.getLevel().getServer().createCommandSourceStack());
                helper.assertTrue(commandResult == 1, Component.literal("/cangsheng debug profile returned no result"));
            } catch (CommandSyntaxException exception) {
                helper.fail("/cangsheng debug profile failed: " + exception.getMessage());
            }
            helper.succeed();
        }

        @Override
        public MapCodec<RegistrySmokeTest> codec() {
            return CODEC;
        }

        private TestData<Holder<TestEnvironmentDefinition<?>>> testData() {
            return info();
        }

        @Override
        protected net.minecraft.network.chat.MutableComponent typeDescription() {
            return Component.translatable("test_instance.type.function");
        }
    }
}

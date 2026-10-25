$ErrorActionPreference = 'Stop'

$root = Split-Path -Parent $PSScriptRoot
$sourceDir = Join-Path $PSScriptRoot 'svg/item'
$outputDir = Join-Path $root 'src/main/resources/assets/cangsheng/textures/item'
$inkscape = Get-Command inkscape -ErrorAction SilentlyContinue
$resvg = Get-Command resvg -ErrorAction SilentlyContinue

if (-not $inkscape -and -not $resvg) {
    Write-Output 'No Inkscape or resvg CLI found; SVG sources are ready, PNG export skipped.'
    exit 0
}

New-Item -ItemType Directory -Path $outputDir -Force | Out-Null
Get-ChildItem -LiteralPath $sourceDir -Filter '*.svg' -File | ForEach-Object {
    $png = Join-Path $outputDir ($_.BaseName + '.png')
    if ($inkscape) {
        & $inkscape.Source $_.FullName '--export-type=png' "--export-filename=$png" '--export-width=16' '--export-height=16'
    } else {
        & $resvg.Source $_.FullName $png '--width' '16' '--height' '16'
    }
    if ($LASTEXITCODE -ne 0) {
        throw "SVG export failed for $($_.Name) with exit code $LASTEXITCODE"
    }
}

Write-Output "Exported 7 item textures to $outputDir"

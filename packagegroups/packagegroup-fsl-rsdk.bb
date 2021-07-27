#
#   Copyright 2021 NXP
#   Definitions for all packages provided by rsdk layer
#

SUMMARY = "All packages provided by RSDK"
LICENSE = "MIT"

inherit packagegroup

PROVIDES = "packagegroup-fsl-rsdk"

# definitions of the RSDK specific packages : modules and applications/demos
RDEPENDS_packagegroup-fsl-rsdk = "\
	packagegroup-rsdk-drivers \
	packagegroup-rsdk-demos \
"

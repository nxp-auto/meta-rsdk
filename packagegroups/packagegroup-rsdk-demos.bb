#
#   Copyright 2021 NXP
#   Definitions for rsdk-demo package
#

SUMMARY = "RSDK Demos"
LICENSE = "MIT"

inherit packagegroup

PROVIDES = "packagegroup-rsdk-demos"

# the recepies to be added for applications/demos
RDEPENDS_packagegroup-rsdk-demos = "\
"

# For the moment no applications included in yocto built
#	csi-tester \

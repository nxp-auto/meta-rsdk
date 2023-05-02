#
#   Copyright 2021-2023 NXP
#   Definitions for rsdk-drivers package
#

SUMMARY = "RSDK Linux Kernel Drivers"
LICENSE = "MIT"

inherit packagegroup

PROVIDES = "packagegroup-rsdk-drivers"

# added all RadarSDK kernel drivers/modules
RDEPENDS_packagegroup-rsdk-drivers = "\
	osal-driver \
	csi2-driver \
	cte-driver \
	lax-driver \
	spt-driver \
	spi-driver \
"


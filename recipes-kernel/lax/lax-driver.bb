#
#   Copyright 2021-2023 NXP
#   BitBake layer description for CTE driver
#

DESCRIPTION = "RSDK LAX driver"
LICENSE = "GPL-2.0-only"

DEPENDS = "osal-kernel-lib"

# include the general kernel build parameters
require recipes-kernel/rsdk_kmod.inc
inherit module externalsrc

# adjust the EXTERNALSRC to the real make file to be used
EXTERNALSRC := "${RSDK_PATH}/LAX/LAX_host/driver/lax/build-linux-kernel"
EXTERNALSRC_BUILD := "${EXTERNALSRC}"

# added some missing build params in the LAX make file
EXTRA_OEMAKE += "CAPATH=${EXTERNALSRC_BUILD}"

# kernel module connection between csi2-driver and the final module file
PROVIDES += "kernel-module-rsdk-lax-driver${KERNEL_MODULE_PACKAGE_SUFFIX}"
RPROVIDES_${PN} += "kernel-module-rsdk-lax-driver${KERNEL_MODULE_PACKAGE_SUFFIX}"


###########################################################################
# setup for CodeAurora, kept as reference
#EXTERNALSRC := "${WORKDIR}/../../osal-kernel-lib/1.0-r0/git/LAX/LAX_host/driver/lax/build-linux-kernel"
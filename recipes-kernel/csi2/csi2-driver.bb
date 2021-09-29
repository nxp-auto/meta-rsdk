#
#   Copyright 2021 NXP
#   BitBake layer description for CSI2 driver
#

DESCRIPTION = "RSDK CSI2 driver"
LICENSE = "GPLv2"

# to be built after OAL module
DEPENDS = "osal-kernel-lib"

# include the general kernel build parameters
require recipes-kernel/rsdk_kmod.inc
inherit module externalsrc

# EXTERNALSRC for CodeAurora processing
EXTERNALSRC := "${WORKDIR}/../../osal-kernel-lib/1.0-r0/git/CSI2/CSI2_driver"

EXTERNALSRC_BUILD = "${EXTERNALSRC}"

# specify the real path for the Module.symvers generated file
MODULES_MODULE_SYMVERS_LOCATION = "project/linux"

# kernel module connection between csi2-driver and the final module file
PROVIDES += "kernel-module-rsdk-csi2-driver${KERNEL_MODULE_PACKAGE_SUFFIX}"
RPROVIDES_${PN} += "kernel-module-rsdk-csi2-driver${KERNEL_MODULE_PACKAGE_SUFFIX}"


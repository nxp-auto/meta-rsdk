#
#   Copyright 2021-2023 NXP
#   BitBake layer description for CSI2 driver
#

DESCRIPTION = "RSDK CSI2 driver"
LICENSE = "GPL-2.0-only"

# to be built after OAL module
DEPENDS = "osal-driver"

# include the general kernel build parameters
require recipes-kernel/rsdk_kmod.inc
inherit module externalsrc

# EXTERNALSRC for GitHub processing
EXTERNALSRC := "${WORKDIR}/../../osal-kernel-lib/1.0-r0/git/CSI2/CSI2_driver"

EXTERNALSRC_BUILD = "${EXTERNALSRC}"

# specify the real path for the Module.symvers generated file
MODULES_MODULE_SYMVERS_LOCATION = "project/S32R45/Linux"

# kernel module connection between csi2-driver and the final module file
PROVIDES += "kernel-module-rsdk-csi2-driver${KERNEL_MODULE_PACKAGE_SUFFIX}"
RPROVIDES_${PN} += "kernel-module-rsdk-csi2-driver${KERNEL_MODULE_PACKAGE_SUFFIX}"


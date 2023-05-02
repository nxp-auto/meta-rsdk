#
#   Copyright 2021-2023 NXP
#   BitBake layer description for CTE driver
#

DESCRIPTION = "RSDK CTE driver"
LICENSE = "GPLv2"

# to be built after OAL module
DEPENDS = "osal-driver"

# include the general kernel build parameters
require recipes-kernel/rsdk_kmod.inc
inherit module externalsrc

# EXTERNALSRC for GitHub recipe
EXTERNALSRC := "${WORKDIR}/../../osal-kernel-lib/1.0-r0/git/CTE/CTE_driver"
EXTERNALSRC_BUILD = "${EXTERNALSRC}"

# specify the real path for the Module.symvers generated file
MODULES_MODULE_SYMVERS_LOCATION = "project/S32R45/Linux"

# kernel module connection between csi2-driver and the final module file
PROVIDES += "kernel-module-rsdk-cte-driver${KERNEL_MODULE_PACKAGE_SUFFIX}"
RPROVIDES_${PN} += "kernel-module-rsdk-cte-driver${KERNEL_MODULE_PACKAGE_SUFFIX}"


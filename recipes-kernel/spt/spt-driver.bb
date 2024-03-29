#
#   Copyright 2021-2023 NXP
#   BitBake layer description for SPT driver
#

DESCRIPTION = "RSDK SPT driver"
LICENSE = "GPL-2.0-only"

# include the general kernel build parameters
require recipes-kernel/rsdk_kmod.inc
inherit module externalsrc

# to be built after OAL module
DEPENDS = "osal-driver"

# EXTERNALSRC for GitHub recipe
EXTERNALSRC := "${WORKDIR}/../../osal-kernel-lib/1.0-r0/git/SPT/SPT_driver/build/linux_kernel"
EXTERNALSRC_BUILD := "${EXTERNALSRC}"

# other parameters for build
EXTRA_OEMAKE += " CAPATH=${EXTERNALSRC_BUILD}"

# kernel module connection between spt-driver and the final module file
PROVIDES += "kernel-module-rsdk-spt-driver${KERNEL_MODULE_PACKAGE_SUFFIX}"
RPROVIDES_${PN} += "kernel-module-rsdk-spt-driver${KERNEL_MODULE_PACKAGE_SUFFIX}"


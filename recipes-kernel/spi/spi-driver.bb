#
#   Copyright 2021 NXP
#   BitBake layer description for SPI driver
#

DESCRIPTION = "RSDK SPI driver"
LICENSE = "GPLv2"

# to be built after OAL module
DEPENDS = "osal-driver"

# include the general kernel build parameters
require recipes-kernel/rsdk_kmod.inc
inherit module externalsrc

# EXTERNALSRC for CodeAurora recipe
EXTERNALSRC := "${WORKDIR}/../../osal-kernel-lib/1.0-r0/git/RFE_abstract/SPI/SPI_driver_linux"
EXTERNALSRC_BUILD := "${EXTERNALSRC}"

# other parameters for build
EXTRA_OEMAKE += " CAPATH=${EXTERNALSRC_BUILD}"

# kernel module connection between spi-driver and the final module file
PROVIDES += "kernel-module-rsdk-spi-driver${KERNEL_MODULE_PACKAGE_SUFFIX}"
RPROVIDES_${PN} += "kernel-module-rsdk-spi-driver${KERNEL_MODULE_PACKAGE_SUFFIX}"


#
#   Copyright 2021-2023 NXP
#   BitBake layer description for O[S]AL driver
#

DESCRIPTION = "OS Abstraction Layer driver"
LICENSE = "GPL-2.0-only"
inherit module
inherit externalsrc

# to be built after OAL kernel library is built
DEPENDS = "osal-kernel-lib"

# include the general rsdk kernel build parameters
require recipes-core/rsdk_env.inc

# adjust the EXTERNALSRC to the real make file to be used
EXTERNALSRC := "${RSDK_PATH}/oal"
EXTERNALSRC_BUILD = "${EXTERNALSRC}/libs/kernel/driver/build-linux-kernel"
MDIR = "${RSDK_PATH}/oal/libs/kernel/linux-write/build-linux-kernel"

# supplementary definitions
export CDEFS = " -DOAL_MAX_EVENTS_PER_SERVICE=64U -DOAL_MAX_PROCESS_COMM_SHARED_BUFFER=15000 -DOAL_MAX_REGION_SIZE=0xFFFFFFFFU -DOAL_VAS_MAX_ALLOCATION=0xFFFFFFFFU -DOAL_MAX_PHYS_ALLOCATION_PER_CHUNK=0xFFFFFFFFU "

# kernel module connection between osal-driver and the final module file
PROVIDES += "kernel-module-osal-driver${KERNEL_MODULE_PACKAGE_SUFFIX}"
RPROVIDES_${PN} += "kernel-module-osal-driver${KERNEL_MODULE_PACKAGE_SUFFIX}"

###########################################################################
# setup for CodeAurora, kept as reference
#EXTERNALSRC := "${WORKDIR}/../../osal-kernel-lib/1.0-r0/git/oal"


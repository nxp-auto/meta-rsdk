#
#   Copyright 2021 NXP
#   General definitions for RSDK layer environment
#

# KERNEL_SRC is the path necessary to build modules out of tree
KERNEL_SRC ?= "${TOPDIR}/tmp/work/s32r45evb-fsl-linux/linux-s32/5.10.41-r0/build"

# supplementary build parameter necessary to the RSDK modules built
EXTRA_OEMAKE += " KERNEL_DIR=${KERNEL_SRC}"


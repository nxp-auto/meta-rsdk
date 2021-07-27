#
#   Copyright 2021 NXP
#   RSDK layer image install definitions
#

# main file for installation
RSDK_IMAGE_BASE ??= "fsl-image-base.bb"

# adding required image to build
require recipes-fsl/images/${RSDK_IMAGE_BASE}

# add the rsdk package to the S32R45-EVB build
IMAGE_INSTALL_append_s32r45evb = " packagegroup-fsl-rsdk"

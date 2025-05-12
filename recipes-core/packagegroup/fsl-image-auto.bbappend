#
#   Copyright 2021-2023 NXP
#   Append definitions for rsdk layer
#

# file description
DESCRIPTION = "Custom list of packages for build rSDK package"

# all defined packages to be appended

# general package
IMAGE_INSTALL:append = " packagegroup-fsl-rsdk"

# drivers/modules package
IMAGE_INSTALL:append = " packagegroup-rsdk-drivers"

# demos package
IMAGE_INSTALL:append = " packagegroup-rsdk-demos"

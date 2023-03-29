# GraphicsEngine

## About
Hello, I am working on a small scale Image Creator that edits a BufferedImage Bitmap and produces a nice raster image. This currently only works with a static resulting image, but will eventually convert to a window to display realtime updates.

---

## Current Possibilities
1. Initializing a Blank Image With a Set Pixel Width and Height
1. Setting a Singular Pixel Pixel on the Screen to a Certain Pixel Value
1. Coloring the Entire Image
1. Drawing a Polygon with a Vertex Array
1. Drawing a Line from (x1,y1) to (x2,y2) via Bresenham's Algrorithm
1. Filling a Selected Region with Scanline Filling
1. Saving Images to a File and Within a Directory if it Exists
1. Transparency Value Correction (Basically, Transparent Pixels are Allowed)

---

## Quick Example (Will Add More)

![Very Happy After This One Worked](/img/image.png "Showing Off Algorithms")

---

## Future Plans

1. Scaling (Two Types)
    - Basic Scaling: Transfer all Pixels on the Smaller or Larger Image to its relative ajacent pixels based on how much the scaling is done
    - Object Sensitive: Only the Points are "Scaled", Lines would be the same stroke length, but the points would be in the new scaled position
1. Frame Editor
    - Possible Using JFrame, create a window that the image can be loaded into and edited live and saved separately when ready
    - Only Bitmap would be loaded, doesn't use ImageIO until saving
1. Circles and Regular Polygons
    - Lord Help Me





# Tetris

English | [中文介绍](https://github.com/vitaviva/compose-tetris/blob/master/README_zh.md)

![](https://img.shields.io/badge/min_sdk_versioin-21-orange.svg)

This project is based on [compose-tetris](https://github.com/vitaviva/compose-tetris), and the code has been optimized on the original basis.

## :scroll: Description

A tetris game fully built using [Jetpack Compose](https://developer.android.com/jetpack/compose), almost all UI elements are created by code, including the following app icon, which is also generated by Composable with @Preview.


<img src="app/src/main/res/drawable/ic_launcher.png" width=110 align=left hspace="10" vspace="10"  >


- MVI architecture
- Simulate appearance of LCD screen
- Game sound and clock
- Inspired by [react-tetris](https://github.com/chvin/react-tetris/blob/master/README-EN.md)

Download latest APK [here](https://github.com/YangDai-Github/Tetris-Android/blob/master/app/release/app-release.apk)

#### Game Rules：
- 100 points for 1 line, 300 points for 2 lines, 700 points for 3 lines, 1500 points for 4 lines;
- The drop speed of the box increases with the number of rows eliminated (one level for every 20 lines);

## :camera_flash: Screenshots
<img src="/results/screenshot.gif" width="480">


## License
```
MIT License

Copyright (c) 2023 Yang Dai

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.
```

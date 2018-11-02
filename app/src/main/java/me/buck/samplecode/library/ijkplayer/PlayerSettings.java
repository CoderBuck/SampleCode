/*
 * Copyright (C) 2015 Bilibili
 * Copyright (C) 2015 Zhang Rui <bbcallen@gmail.com>
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package me.buck.samplecode.library.ijkplayer;

public class PlayerSettings {

    public static final int PLAYER__AndroidMediaPlayer = 1;
    public static final int PLAYER__IjkMediaPlayer     = 2;

    private static boolean sEnableBackgroundPlay      = false;
    private static boolean sUsingMediaCodec           = true;
    private static boolean sUsingMediaCodecAutoRotate = true;


    private static int sPlayer = PLAYER__AndroidMediaPlayer;

    public PlayerSettings() {
    }

    public static int getPlayer() {
        return sPlayer;
    }

    public static void setPlayer(int player) {
        sPlayer = player;
    }

    ///////////////////////////////////////////////////////////////////////////
    // not use
    ///////////////////////////////////////////////////////////////////////////

    public boolean getEnableBackgroundPlay() {
        return sEnableBackgroundPlay;
    }

    public boolean getUsingMediaCodec() {
        return sUsingMediaCodec;
    }

    public boolean getUsingMediaCodecAutoRotate() {
        return sUsingMediaCodecAutoRotate;
    }

    public boolean getMediaCodecHandleResolutionChange() {
        return sUsingMediaCodec;
    }

    public boolean getUsingOpenSLES() {
        return false;
    }

    public String getPixelFormat() {
        return "";
    }

    public boolean getEnableNoView() {
        return false;
    }

    public boolean getEnableSurfaceView() {
        return false;
    }

    public boolean getEnableTextureView() {
        return true;
    }

    public boolean getEnableDetachedSurfaceTextureView() {
        return false;
    }

}

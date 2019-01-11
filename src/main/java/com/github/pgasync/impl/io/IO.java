/*
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.github.pgasync.impl.io;

import java.io.ByteArrayOutputStream;
import java.nio.ByteBuffer;

import static java.nio.charset.StandardCharsets.UTF_8;

/**
 * Static utility methods for input/output.
 * 
 * @author Antti Laisi
 */
public enum IO {
    ;

    public static byte[] bytes(String s) {
        return s.getBytes(UTF_8);
    }

    public static String getCString(ByteBuffer buffer) {
        ByteArrayOutputStream store = new ByteArrayOutputStream();
        for (byte c = buffer.get(); c != 0; c = buffer.get()) {
            store.write(c);
        }
        return store.toString();
    }

    public static void putCString(ByteBuffer buffer, String string) {
        buffer.put(bytes(string));
        buffer.put((byte) 0);
    }

}

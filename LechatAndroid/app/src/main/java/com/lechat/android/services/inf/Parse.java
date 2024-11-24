package com.lechat.android.services.inf;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author: Seain
 * @Date: on 2024-10-20 19:55.
 * @Description: 描述
 */
public interface Parse<T> {
     List<T> parse(InputStream inStream) throws Throwable;
}

package com.lechat.android.services.impl;

import com.lechat.android.services.Emoji;
import com.lechat.android.services.inf.Parse;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserFactory;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author: Seain
 * @Date: on 2024-10-20 19:54.
 * @Description: 解析器
 */
public class EmojiParser implements Parse<Emoji> {
    @Override
    public List<Emoji> parse(InputStream inStream) throws Throwable {
        List<Emoji> emojis = null;
        Emoji emoji = null;

        XmlPullParserFactory pullFactory = XmlPullParserFactory.newInstance();
        XmlPullParser parser = pullFactory.newPullParser();
        parser.setInput(inStream, "UTF-8");
        int eventType = parser.getEventType();
        while (eventType != XmlPullParser.END_DOCUMENT) {
            switch (eventType) {
                case XmlPullParser.START_DOCUMENT:
                    emojis = new ArrayList<Emoji>();
                    break;
                case XmlPullParser.START_TAG:
                    String name = parser.getName();
                    if ("face".equals(name)) {
                        emoji = new Emoji();

                        emoji.setFaceid(parser.getAttributeValue(0));
                        emoji.setFile(parser.getAttributeValue(1));
                        emoji.setTip(parser.getAttributeValue(2));

                    }

                    break;
                case XmlPullParser.END_TAG:
                    if ("face".equals(parser.getName())) {
                        emojis.add(emoji);
                        emoji = null;
                    }
                    break;
                default:
                    break;
            }
            eventType = parser.next();
        }
        return emojis;
    }

    public static List<Emoji> parse_input(InputStream inStream) throws Throwable {
        List<Emoji> emojis = null;
        Emoji emoji = null;

        XmlPullParserFactory pullFactory = XmlPullParserFactory.newInstance();
        XmlPullParser parser = pullFactory.newPullParser();
        parser.setInput(inStream, "UTF-8");
        int eventType = parser.getEventType();
        while (eventType != XmlPullParser.END_DOCUMENT) {
            switch (eventType) {
                case XmlPullParser.START_DOCUMENT:
                    emojis = new ArrayList<Emoji>();
                    break;
                case XmlPullParser.START_TAG:
                    String name = parser.getName();
                    if ("face".equals(name)) {
                        emoji = new Emoji();

                        emoji.setFaceid(parser.getAttributeValue(0));
                        emoji.setFile(parser.getAttributeValue(1));
                        emoji.setTip(parser.getAttributeValue(2));

                    }

                    break;
                case XmlPullParser.END_TAG:
                    if ("face".equals(parser.getName())) {
                        emojis.add(emoji);
                        emoji = null;
                    }
                    break;
                default:
                    break;
            }
            eventType = parser.next();
        }
        return emojis;
    }
}

/*
 * Copyright 2011 JBoss Inc
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.drools.mas.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import org.drools.mas.mappers.MyMapArgsEntryType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author salaboy
 */
public class MapArgsAdapterHelper {

    public static Logger logger = LoggerFactory.getLogger(MapArgsAdapterHelper.class);

    public static List<MyMapArgsEntryType> marshal(Map<String, Object> arg0) {
        if (logger.isTraceEnabled()) {
            logger.trace(" $$$ Arguments to marshal( "+arg0+")");
        }
        List<MyMapArgsEntryType> entries = new ArrayList<MyMapArgsEntryType>();
        for (Entry<String, Object> entry : arg0.entrySet()) {
            MyMapArgsEntryType myMapEntryType =
                    new MyMapArgsEntryType();
            myMapEntryType.setKey(entry.getKey());
            myMapEntryType.setValue(entry.getValue());
            entries.add(myMapEntryType);
        }
        return entries;
    }

    public static Map<String, Object> unmarshal(List<MyMapArgsEntryType> arg0) {
        if (logger.isTraceEnabled()) {
            logger.trace(" $$$ Arguments to unmarshal( "+arg0+")");
        }
        HashMap<String, Object> hashMap = new HashMap<String, Object>();
        for (MyMapArgsEntryType myEntryType : arg0) {
            hashMap.put(myEntryType.getKey(), myEntryType.getValue());
        }
        return hashMap;
    }
}

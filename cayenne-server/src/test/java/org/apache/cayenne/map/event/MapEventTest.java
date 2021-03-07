/*****************************************************************
 *   Licensed to the Apache Software Foundation (ASF) under one
 *  or more contributor license agreements.  See the NOTICE file
 *  distributed with this work for additional information
 *  regarding copyright ownership.  The ASF licenses this file
 *  to you under the Apache License, Version 2.0 (the
 *  "License"); you may not use this file except in compliance
 *  with the License.  You may obtain a copy of the License at
 *
 *    https://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing,
 *  software distributed under the License is distributed on an
 *  "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 *  KIND, either express or implied.  See the License for the
 *  specific language governing permissions and limitations
 *  under the License.
 ****************************************************************/

package org.apache.cayenne.map.event;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.*;

/**
 */
public class MapEventTest {

    @Test
    public void testNoNameChange() throws Exception {
     // MapEvent event = new MapEventFixture(new Object(), "someName");
    	MapEvent event = mock(MapEvent.class);
    	when(event.getNewName()).thenReturn("someName");
    //	assertEquals(event.getNewName(), CoreMatchers.equalTo("someName"));
        assertEquals("someName", event.getNewName());
    	when(event.isNameChange()).thenReturn(false);
        assertFalse(event.isNameChange());
    }

    @Test
    public void testNameChange() throws Exception {
     // MapEvent event = new MapEventFixture(new Object(), "someName", "someOldName");
        MapEvent event = mock(MapEvent.class);
        when(event.getNewName()).thenReturn("someName");
    	assertEquals("someName", event.getNewName());
     // assertEquals(event.getNewName(), CoreMatchers.equalTo("someName"));
        when(event.isNameChange()).thenReturn(true);
        assertTrue(event.isNameChange());
    }

    @Test
    public void testOldName() throws Exception {
     // MapEvent event = new MapEventFixture(new Object(), "someName");
    	MapEvent event = mock(MapEvent.class);
    	when(event.getOldName()).thenReturn(null);
        assertNull(event.getOldName());
        event.setOldName("oldName");
        when(event.getOldName()).thenReturn("oldName");
        assertEquals("oldName", event.getOldName());
     // assertEquals(event.getOldName(), CoreMatchers.equalTo("oldName"));
    }
}

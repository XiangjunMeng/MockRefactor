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

package org.apache.cayenne.modeler.event;

import org.apache.cayenne.map.event.MapEvent;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.*;
/**
 */
public class ModelerEventTest {

    @Test
    public void testConstructor1() throws Exception {
    	Object src = new Object();
   // 	MapEvent e = new TestMapEvent(src);
    	MapEvent e = mock(MapEvent.class);
    	when(e.getSource()).thenReturn(src);
    	assertSame(src, e.getSource());
    }

	@Test
    public void testId() throws Exception  {
    //	MapEvent e = new TestMapEvent(new Object());
	MapEvent e = mock(MapEvent.class);
	when(e.getId()).thenReturn(MapEvent.CHANGE);
    	assertEquals(MapEvent.CHANGE, e.getId());
    	
    	e.setId(MapEvent.ADD);
    	when(e.getId()).thenReturn(MapEvent.ADD);
    	assertEquals(MapEvent.ADD, e.getId());
    }
}


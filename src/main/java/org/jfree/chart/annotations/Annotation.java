/* ===========================================================
 * JFreeChart : a free chart library for the Java(tm) platform
 * ===========================================================
 *
 * (C) Copyright 2000-present, by David Gilbert and Contributors.
 *
 * Project Info:  http://www.jfree.org/jfreechart/index.html
 *
 * This library is free software; you can redistribute it and/or modify it
 * under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation; either version 2.1 of the License, or
 * (at your option) any later version.
 *
 * This library is distributed in the hope that it will be useful, but
 * WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY
 * or FITNESS FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public
 * License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this library; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA  02110-1301,
 * USA.
 *
 * [Oracle and Java are registered trademarks of Oracle and/or its affiliates. 
 * Other names may be trademarks of their respective owners.]
 *
 * ---------------
 * Annotation.java
 * ---------------
 * (C) Copyright 2009-present, by Peter Kolb and Contributors.
 *
 * Original Author:  Peter Kolb (see patch 2809117);
 * Contributor(s):   ;
 *
 */

package org.jfree.chart.annotations;

import org.jfree.chart.event.AnnotationChangeListener;

/**
 * The base interface for annotations.  All annotations should support
 * {@link AnnotationChangeListener} via the addChangeListener and
 * removeChangeListener methods.
 */
public interface Annotation {

    /**
     * Registers an object for notification of changes to the annotation.
     *
     * @param listener  the object to register.
     */
    void addChangeListener(AnnotationChangeListener listener);

    /**
     * Deregisters an object for notification of changes to the annotation.
     *
     * @param listener  the object to deregister.
     */
    void removeChangeListener(AnnotationChangeListener listener);

}

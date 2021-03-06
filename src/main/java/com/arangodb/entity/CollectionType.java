/*
 * Copyright (C) 2012 tamtam180
 *
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

package com.arangodb.entity;

/**
 * Enumeration class for collection types.
 *
 * @author tamtam180 - kirscheless at gmail.com
 *
 */
public enum CollectionType {
  /**
   * Document collection type
   */
  DOCUMENT(2),

  /**
   * Edge collection type, used for graphs
   */
  EDGE(3);
  private final int type;
  private CollectionType(int type) {
    this.type = type;
  }
  public int getType() {
    return type;
  }
  public static CollectionType valueOf(int type) {
    switch (type) {
    case 2:
      return DOCUMENT;
    case 3:
      return EDGE;
    }
    return null;
  }
}

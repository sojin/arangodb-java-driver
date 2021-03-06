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
 * The generic document entity
 *
 * @author tamtam180 - kirscheless at gmail.com
 *
 */
public class DocumentEntity<T> extends BaseEntity implements DocumentHolder {

  /**
   * the documents revision number
   */
  long documentRevision;

  /**
   * the document handle
   */
  String documentHandle;

  /**
   * the document key
   */
  String documentKey;

  /**
   * The entity representation of the requested document.
   */
  T entity;
  
  public DocumentEntity() {
  }

  public long getDocumentRevision() {
    return documentRevision;
  }

  public String getDocumentHandle() {
    return documentHandle;
  }

  public T getEntity() {
    return entity;
  }

  public void setDocumentRevision(long documentRevision) {
    this.documentRevision = documentRevision;
  }

  public void setDocumentHandle(String documentHandle) {
    this.documentHandle = documentHandle;
  }

  public void setEntity(T entity) {
    this.entity = entity;
  }

  public String getDocumentKey() {
    return documentKey;
  }

  public void setDocumentKey(String documentKey) {
    this.documentKey = documentKey;
  }
  
}

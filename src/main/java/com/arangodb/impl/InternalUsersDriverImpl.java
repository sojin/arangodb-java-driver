/*
 * Copyright (C) 2012,2013 tamtam180
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

package com.arangodb.impl;

import java.util.Map;

import com.arangodb.ArangoConfigure;
import com.arangodb.ArangoException;
import com.arangodb.entity.DefaultEntity;
import com.arangodb.entity.EntityFactory;
import com.arangodb.entity.UserEntity;
import com.arangodb.entity.UsersEntity;
import com.arangodb.http.HttpManager;
import com.arangodb.http.HttpResponseEntity;
import com.arangodb.util.MapBuilder;
import com.arangodb.util.StringUtils;

/**
 * @author tamtam180 - kirscheless at gmail.com
 * 
 */
public class InternalUsersDriverImpl extends BaseArangoDriverImpl implements com.arangodb.InternalUsersDriver {

  InternalUsersDriverImpl(ArangoConfigure configure, HttpManager httpManager) {
    super(configure , httpManager);
  }

  @Override
  public DefaultEntity createUser(String database, String username, String passwd, Boolean active,
                                  Map<String, Object> extra) throws ArangoException {

    HttpResponseEntity res = httpManager.doPost(
        createEndpointUrl(baseUrl, database, "/_api/user"),
        null,
        EntityFactory.toJsonString(new MapBuilder().put("username", username).put("passwd", passwd)
            .put("active", active).put("extra", extra).get()));

    return createEntity(res, DefaultEntity.class);

  }

  @Override
  public DefaultEntity deleteUser(String database, String username) throws ArangoException {

    HttpResponseEntity res = httpManager.doDelete(
        createEndpointUrl(baseUrl, database, "/_api/user", StringUtils.encodeUrl(username)), null);

    return createEntity(res, DefaultEntity.class);

  }

  @Override
  public UserEntity getUser(String database, String username) throws ArangoException {

    HttpResponseEntity res = httpManager.doGet(
        createEndpointUrl(baseUrl, database, "/_api/user", StringUtils.encodeUrl(username)), null);

    return createEntity(res, UserEntity.class);

  }

  @Override
  public UsersEntity getUsers(String database) throws ArangoException {

    HttpResponseEntity res = httpManager.doGet(createEndpointUrl(baseUrl, database, "/_api/user"), null);

    return createEntity(res, UsersEntity.class);

  }

  @Override
  public DefaultEntity replaceUser(String database, String username, String passwd, Boolean active,
                                   Map<String, Object> extra) throws ArangoException {

    HttpResponseEntity res = httpManager.doPut(
        createEndpointUrl(baseUrl, database, "/_api/user", StringUtils.encodeUrl(username)),
        null,
        EntityFactory.toJsonString(new MapBuilder().put("passwd", passwd).put("active", active)
            .put("extra", extra).get()));

    return createEntity(res, DefaultEntity.class);

  }

  @Override
  public DefaultEntity updateUser(String database, String username, String passwd, Boolean active,
                                  Map<String, Object> extra) throws ArangoException {

    HttpResponseEntity res = httpManager.doPatch(
        createEndpointUrl(baseUrl, database, "/_api/user", StringUtils.encodeUrl(username)),
        null,
        EntityFactory.toJsonString(new MapBuilder().put("passwd", passwd).put("active", active)
            .put("extra", extra).get()));

    return createEntity(res, DefaultEntity.class);

  }

}

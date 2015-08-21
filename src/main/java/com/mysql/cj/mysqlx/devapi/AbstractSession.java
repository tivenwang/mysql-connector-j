/*
  Copyright (c) 2015, Oracle and/or its affiliates. All rights reserved.

  The MySQL Connector/J is licensed under the terms of the GPLv2
  <http://www.gnu.org/licenses/old-licenses/gpl-2.0.html>, like most MySQL Connectors.
  There are special exceptions to the terms and conditions of the GPLv2 as it is applied to
  this software, see the FOSS License Exception
  <http://www.mysql.com/about/legal/licensing/foss-exception.html>.

  This program is free software; you can redistribute it and/or modify it under the terms
  of the GNU General Public License as published by the Free Software Foundation; version 2
  of the License.

  This program is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY;
  without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.
  See the GNU General Public License for more details.

  You should have received a copy of the GNU General Public License along with this
  program; if not, write to the Free Software Foundation, Inc., 51 Franklin St, Fifth
  Floor, Boston, MA 02110-1301  USA

 */

package com.mysql.cj.mysqlx.devapi;

import java.util.List;

import com.mysql.cj.api.x.BaseSession;
import com.mysql.cj.api.x.Schema;
import com.mysql.cj.mysqlx.MysqlxSession;

/**
 * @todo
 */
public abstract class AbstractSession implements BaseSession {

    protected MysqlxSession session;
    protected String defaultSchemaName;

    @Override
    public List<Schema> getSchemas() {
        throw new NullPointerException("TODO:");
    }

    @Override
    public Schema getSchema(String name) {
        throw new NullPointerException("TODO:");
    }

    @Override
    public Schema getDefaultSchema() {
        throw new NullPointerException("TODO:");
    }

    @Override
    public Schema createSchema(String name) {
        throw new NullPointerException("TODO:");
    }

    @Override
    public Schema createSchema(String name, boolean reuseExistingObject) {
        throw new NullPointerException("TODO:");
    }

    @Override
    public Schema dropSchema(String name) {
        throw new NullPointerException("TODO:");
    }

    @Override
    public String getUri() {
        throw new NullPointerException("TODO:");
    }

    @Override
    public void close() {
        this.session.close();
    }

    @Override
    public MysqlxSession getMysqlxSession() {
        return this.session;
    }

    public void startTransaction() {
        throw new NullPointerException("TODO:");
    }

    public void commit() {
        throw new NullPointerException("TODO:");
    }

    public void rollback() {
        throw new NullPointerException("TODO:");
    }

}

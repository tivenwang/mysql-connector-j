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

package testsuite.mysqlx.devapi;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.mysql.cj.api.x.FetchedRows;
import com.mysql.cj.api.x.Table;
import com.mysql.cj.api.x.Row;

/**
 * @todo
 */
public class TableInsertTest extends TableTest {
    @Before
    @Override
    public void setupTableTest() {
        super.setupTableTest();
    }

    @After
    @Override
    public void teardownTableTest() {
        super.teardownTableTest();
    }

    @Test
    public void basicInsert() {
        String tableName = "basicInsert";
        sqlUpdate("drop table if exists basicInsert");
        sqlUpdate("create table basicInsert (_id varchar(32), name varchar(20) not null default 'unknown', birthday date, age int)");
        Table table = this.schema.getTable(tableName);
        // insert with fields and values separately
        table.insert("_id", "birthday", "age").values(1, "2015-01-01", 1).execute();
        // insert all fields with values
        table.insert().values(2, "Orlando", "2014-01-01", 2).execute();
        Map<String, Object> row = new HashMap<>();
        row.put("_id", 3);
        row.put("age", 3);
        // insert a row in k/v pair form
        table.insert(row).execute();

        FetchedRows rows = table.select("_id, name, birthday, age").orderBy("_id").execute();
        Row r = rows.next();
        assertEquals("1", r.getString("_id"));
        assertEquals("unknown", r.getString("name"));
        assertEquals("2015-01-01", r.getString("birthday"));
        assertEquals(1, r.getInt("age"));
        r = rows.next();
        assertEquals("2", r.getString("_id"));
        assertEquals("Orlando", r.getString("name"));
        assertEquals("2014-01-01", r.getString("birthday"));
        assertEquals(2, r.getInt("age"));
        r = rows.next();
        assertEquals("3", r.getString("_id"));
        assertEquals("unknown", r.getString("name"));
        assertEquals(null, r.getString("birthday"));
        assertEquals(3, r.getInt("age"));
        assertFalse(rows.hasNext());
    }
}

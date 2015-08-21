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

package com.mysql.cj.api.x;

/**
 * MySQLx introduces a new, high-level database session concept that is called Session. When working with MySQLx it is important to understand this new
 * Session concept which is different from working with traditional low-level MySQL connections.
 * 
 * Sessions encapsulate one or more actual MySQL connections. Use of this higher abstraction level decouples the physical MySQL setup from the application code.
 * An application using the Session class can be run against a single MySQL server or large number of MySQL servers forming a sharding cluster with no code
 * changes. When a low-level MySQL connection to a single MySQL instance is needed this is still supported by using a low-level {@link NodeSession}.
 * 
 * The Session concept also separates the concerns of the application developer and the administrator. Developers use the Session class which does not include
 * administration functions. Database administrators use a specialized version of the Session class. An {@link AdminSession} includes the developer
 * functionality and additional administration functionality.
 *
 */
public interface Session extends BaseSession {

}

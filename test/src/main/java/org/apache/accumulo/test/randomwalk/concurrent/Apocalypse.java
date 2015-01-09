/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.apache.accumulo.test.randomwalk.concurrent;

import java.util.Properties;

import org.apache.accumulo.test.randomwalk.Environment;
import org.apache.accumulo.test.randomwalk.State;
import org.apache.accumulo.test.randomwalk.Test;

public class Apocalypse extends Test {

  @Override
  public void visit(State state, Environment env, Properties props) throws Exception {
    Process exec = Runtime.getRuntime().exec(new String[] {System.getenv("ACCUMULO_HOME") + "/test/system/randomwalk/bin/apocalypse.sh"});
    if (exec.waitFor() != 0)
      throw new RuntimeException("apocalypse.sh returned a non-zero response: " + exec.exitValue());
  }

}

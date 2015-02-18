/*
 *
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 *
 */

package org.apache.ariavata.simple.workflow.engine.dag.port;

import org.apache.airavata.model.appcatalog.appinterface.OutputDataObjectType;
import org.apache.ariavata.simple.workflow.engine.dag.edge.Edge;
import org.apache.ariavata.simple.workflow.engine.dag.nodes.WorkflowNode;

import java.util.ArrayList;
import java.util.List;

public class OutPortImpl implements OutPort {

    private OutputDataObjectType outputDataObjectType;
    private List<Edge> outEdges = new ArrayList<Edge>();
    private boolean isSatisfy = false;
    private String portId;
    private WorkflowNode node;

    public OutPortImpl(String portId) {
        this.portId = portId;
    }

    @Override
    public void setOutputObject(OutputDataObjectType outputObject) {
        this.outputDataObjectType = outputObject;
    }

    @Override
    public OutputDataObjectType getOutputObject() {
        return this.outputDataObjectType;
    }

    @Override
    public List<Edge> getOutEdges() {
        return this.outEdges;
    }

    @Override
    public void addEdge(Edge edge) {
        this.outEdges.add(edge);
    }

    @Override
    public boolean isSatisfy() {
        return this.outputDataObjectType.getValue() != null
                && !this.outputDataObjectType.getValue().equals("");
    }

    @Override
    public WorkflowNode getNode() {
        return this.node;
    }

    @Override
    public void setNode(WorkflowNode workflowNode) {
        this.node = workflowNode;
    }

    @Override
    public String getId() {
        return portId;
    }
}

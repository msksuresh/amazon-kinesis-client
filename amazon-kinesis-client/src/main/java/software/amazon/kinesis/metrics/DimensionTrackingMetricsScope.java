/*
 *  Copyright 2018 Amazon.com, Inc. or its affiliates. All Rights Reserved.
 *
 *  Licensed under the Amazon Software License (the "License").
 *  You may not use this file except in compliance with the License.
 *  A copy of the License is located at
 *
 *  http://aws.amazon.com/asl/
 *
 *  or in the "license" file accompanying this file. This file is distributed
 *  on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either
 *  express or implied. See the License for the specific language governing
 *  permissions and limitations under the License.
 */
package software.amazon.kinesis.metrics;

import software.amazon.awssdk.services.cloudwatch.model.Dimension;

import java.util.HashSet;
import java.util.Set;


/**
 * DimensionTrackingMetricsScope is where we provide functionality for dimensions.
 * Dimensions allow the user to be able view their metrics based off of the parameters they specify.
 * 
 * The following examples show how to add dimensions if they would like to view their all metrics
 * pertaining to a particular stream or for a specific date.
 * 
 * myScope.addDimension("StreamName", "myStreamName");
 * myScope.addDimension("Date", "Dec012013");
 * 
 * 
 */

public abstract class DimensionTrackingMetricsScope implements MetricsScope {

    private Set<Dimension> dimensions = new HashSet<>();

    @Override
    public void addDimension(String name, String value) {
        dimensions.add(Dimension.builder().name(name).value(value).build());
    }

    /**
     * @return a set of dimensions for an IMetricsScope
     */

    protected Set<Dimension> getDimensions() {
        return dimensions;
    }

}

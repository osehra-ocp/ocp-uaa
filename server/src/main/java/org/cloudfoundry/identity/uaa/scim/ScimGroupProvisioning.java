/*******************************************************************************
 *     Cloud Foundry
 *     Copyright (c) [2009-2016] Pivotal Software, Inc. All Rights Reserved.
 *
 *     This product is licensed to you under the Apache License, Version 2.0 (the "License").
 *     You may not use this product except in compliance with the License.
 *
 *     This product includes a number of subcomponents with
 *     separate copyright notices and license terms. Your use of these
 *     subcomponents is subject to the terms and conditions of the
 *     subcomponent's license, as noted in the LICENSE file.
 *******************************************************************************/
package org.cloudfoundry.identity.uaa.scim;

import org.cloudfoundry.identity.uaa.resources.Queryable;
import org.cloudfoundry.identity.uaa.resources.ResourceManager;
import org.cloudfoundry.identity.uaa.scim.endpoints.GroupOrScopeDto;

import java.sql.SQLException;
import java.util.List;

public interface ScimGroupProvisioning extends ResourceManager<ScimGroup>, Queryable<ScimGroup> {
    String GROUP_BY_NAME_FILTER = "displayName eq \"%s\"";

    ScimGroup createOrGet(ScimGroup group, String zoneId);

    ScimGroup getByName(String displayName, String zoneId);

    void createScopesOrRoles(List<String> scopes, String groupId, String memberType) throws SQLException;

    List<GroupOrScopeDto> getOcpGroups();

    List<GroupOrScopeDto> getOcpScopes();

    void deleteScopes(String groupId);
}

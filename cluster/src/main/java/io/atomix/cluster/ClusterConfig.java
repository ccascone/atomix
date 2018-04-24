/*
 * Copyright 2018-present Open Networking Foundation
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
package io.atomix.cluster;

import io.atomix.utils.config.Config;
import io.atomix.utils.net.Address;
import io.atomix.utils.net.MalformedAddressException;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Cluster configuration.
 */
public class ClusterConfig implements Config {
  private static final String DEFAULT_CLUSTER_NAME = "atomix";
  private static final String DEFAULT_MULTICAST_IP = "230.0.0.1";
  private static final int DEFAULT_MULTICAST_PORT = 54321;

  private String name = DEFAULT_CLUSTER_NAME;
  private MemberConfig localMember;
  private Collection<MemberConfig> members = new ArrayList<>();
  private boolean multicastEnabled = false;
  private Address multicastAddress;
  private GroupMembershipConfig membership = new GroupMembershipConfig();

  public ClusterConfig() {
    try {
      multicastAddress = Address.from(DEFAULT_MULTICAST_IP, DEFAULT_MULTICAST_PORT);
    } catch (MalformedAddressException e) {
      multicastAddress = Address.from(DEFAULT_MULTICAST_PORT);
    }
  }

  /**
   * Returns the cluster name.
   *
   * @return the cluster name
   */
  public String getName() {
    return name;
  }

  /**
   * Sets the cluster name.
   *
   * @param name the cluster name
   * @return the cluster configuration
   */
  public ClusterConfig setName(String name) {
    this.name = name;
    return this;
  }

  /**
   * Returns the local node configuration.
   *
   * @return the local node configuration
   */
  public MemberConfig getLocalMember() {
    return localMember;
  }

  /**
   * Sets the local node configuration.
   *
   * @param localMember the local node configuration
   * @return the cluster configuration
   */
  public ClusterConfig setLocalMember(MemberConfig localMember) {
    this.localMember = localMember;
    return this;
  }

  /**
   * Returns the cluster nodes.
   *
   * @return the cluster nodes
   */
  public Collection<MemberConfig> getMembers() {
    return members;
  }

  /**
   * Sets the cluster nodes.
   *
   * @param members the cluster nodes
   * @return the cluster configuration
   */
  public ClusterConfig setMembers(Collection<MemberConfig> members) {
    this.members = members;
    return this;
  }

  /**
   * Returns whether multicast is enabled.
   *
   * @return whether multicast is enabled
   */
  public boolean isMulticastEnabled() {
    return multicastEnabled;
  }

  /**
   * Sets whether multicast is enabled.
   *
   * @param multicastEnabled whether multicast is enabled
   * @return the cluster configuration
   */
  public ClusterConfig setMulticastEnabled(boolean multicastEnabled) {
    this.multicastEnabled = multicastEnabled;
    return this;
  }

  /**
   * Returns the multicast address.
   *
   * @return the multicast address
   */
  public Address getMulticastAddress() {
    return multicastAddress;
  }

  /**
   * Sets the multicast address.
   *
   * @param multicastAddress the multicast address
   * @return the cluster configuration
   */
  public ClusterConfig setMulticastAddress(Address multicastAddress) {
    this.multicastAddress = multicastAddress;
    return this;
  }

  /**
   * Returns the group membership configuration.
   *
   * @return the group membership configuration
   */
  public GroupMembershipConfig getMembership() {
    return membership;
  }

  /**
   * Sets the group membership configuration.
   *
   * @param membership the group membership configuration
   * @return the cluster configuration
   */
  public ClusterConfig setMembership(GroupMembershipConfig membership) {
    this.membership = membership;
    return this;
  }
}

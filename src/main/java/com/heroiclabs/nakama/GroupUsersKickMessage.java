/*
 * Copyright 2017 The Nakama Authors
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.heroiclabs.nakama;

import lombok.AccessLevel;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

public interface GroupUsersKickMessage extends CollatedMessage<Boolean> {

    @RequiredArgsConstructor(access = AccessLevel.PRIVATE)
    class Builder {

        public static GroupUsersKickMessage.Builder newBuilder() {
            return new GroupUsersKickMessage.Builder(com.heroiclabs.nakama.Api.TGroupUsersKick.newBuilder());
        }

        private final @NonNull
        com.heroiclabs.nakama.Api.TGroupUsersKick.Builder kicks;

        public GroupUsersKickMessage.Builder add(final @NonNull String groupId, final @NonNull String userId) {
            this.kicks.addGroupUsers(com.heroiclabs.nakama.Api.TGroupUsersKick.GroupUserKick.newBuilder()
                    .setGroupId(groupId)
                    .setUserId(userId)
                    .build());
            return this;
        }

        public GroupUsersKickMessage build() {
            final com.heroiclabs.nakama.Api.Envelope.Builder payload =
                    com.heroiclabs.nakama.Api.Envelope.newBuilder()
                            .setGroupUsersKick(kicks);
            return new DefaultGroupUsersKickMessage(payload);
        }
    }

}

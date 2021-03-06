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

public interface LeaderboardsListMessage extends CollatedMessage<ResultSet<Leaderboard>> {

    @RequiredArgsConstructor(access = AccessLevel.PRIVATE)
    class Builder {

        public static LeaderboardsListMessage.Builder newBuilder() {
            return new LeaderboardsListMessage.Builder(com.heroiclabs.nakama.Api.TLeaderboardsList.newBuilder());
        }

        private final @NonNull
        com.heroiclabs.nakama.Api.TLeaderboardsList.Builder listing;

        public LeaderboardsListMessage.Builder limit(final long limit) {
            listing.setLimit(limit);
            return this;
        }

        public LeaderboardsListMessage.Builder addFilter(final @NonNull String leaderboardId) {
            listing.addFilterLeaderboardId(leaderboardId);
            return this;
        }

        public LeaderboardsListMessage.Builder cursor(final @NonNull String cursor) {
            listing.setCursor(cursor);
            return this;
        }

        public LeaderboardsListMessage build() {
            final com.heroiclabs.nakama.Api.Envelope.Builder payload =
                    com.heroiclabs.nakama.Api.Envelope.newBuilder()
                            .setLeaderboardsList(listing);
            return new DefaultLeaderboardsListMessage(payload);
        }

    }
}

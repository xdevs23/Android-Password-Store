/*
 * Copyright © 2014-2020 The Android Password Store Authors. All Rights Reserved.
 * SPDX-License-Identifier: GPL-3.0-only
 */
package dev.msfjarvis.aps.git.config

enum class ConnectionMode(val pref: String) {
    SshKey("ssh-key"),
    Password("username/password"),
    OpenKeychain("OpenKeychain");

    companion object {
        private val map = values().associateBy(dev.msfjarvis.aps.ng.git.config.ConnectionMode::pref)
        fun fromString(type: String?): dev.msfjarvis.aps.ng.git.config.ConnectionMode {
            return map[type ?: return SshKey]
                ?: throw IllegalArgumentException("$type is not a valid ConnectionMode")
        }
    }
}
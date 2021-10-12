package com.tutlemint.assisment.models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "quote")
data class IssueListItem(
    @PrimaryKey(autoGenerate = true)
    val issueIdDb: Int,
//    val active_lock_reason: Any,
//    val assignee: Any,
//    val assignees: List<Any>,
    val author_association: String,
    val body: String,
//    val closed_at: Any,
    val comments: Int,
    val comments_url: String,
    val created_at: String,
    val events_url: String,
    val html_url: String,
    val id: Int,
//    val labels: List<Label>,
    val labels_url: String,
    val locked: Boolean,
//    val milestone: Milestone,
    val node_id: String,
    val number: Int,
//    val performed_via_github_app: Any,
//    val pull_request: PullRequest,
//    val reactions: Reactions,
    val repository_url: String,
    val state: String,
    val timeline_url: String,
    val title: String,
    val updated_at: String,
    val url: String,
//    val user: User
)
Array.prototype.remove = function (target) {
    return this.filter(item => item !== target)
}

class Comment {
    _comment = [];
    topComment = [];
    childrenArray = [];
    constructor(comment) {
        this._comment = comment;
    }
    map() {
        this._comment
            .filter(comment => comment.parent_comment_id === null)
            .map(comment => {
                comment.childrenComment = []
                this.topComment.push(comment)
            });
        this.childrenArray = this._comment
            .filter(comment => comment.parent_comment_id !== null);
    }
    reduce() {
        //先找出第一级回复
        for (const child_comment of this.childrenArray) {
            for (const top_comment of this.topComment) {
                if (child_comment.parent_comment_id === top_comment.id) {
                    top_comment.childrenComment.push(child_comment)
                    this.childrenArray = this.childrenArray.remove(child_comment);
                    break;
                }
            }
        }
        //找出第一级回复下的所有子回复
        for (const other_comment of this.childrenArray) {
            for (const top_comment of this.topComment) {
                for (const child_comment of top_comment.childrenComment) {
                    if (other_comment.parent_comment_id === child_comment.id) {
                        top_comment.childrenComment.push(other_comment);
                        this.childrenArray = this.childrenArray.remove(other_comment);
                        break;
                    }
                }
            }
        }
    }
    mapReduce() {
        this.map();
        this.reduce();
        return this.topComment;
    }
}

export {
    Comment
}
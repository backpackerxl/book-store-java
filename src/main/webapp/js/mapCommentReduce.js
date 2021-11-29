/**
 * 为数组对象新增一个remove方法，方便数组数据的删除操作
 * @param {要删除的目标值} target 
 * @returns 返回一个被过滤掉的数组对象
 */
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
    /**
     * 对原始数据进行初步的分类处理
     */
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
    /**
     * 对分类好的数据进行统计处理
     */
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
    /**
     * 调用方法进行数据处理
     * @returns 返回评论模块的数据模型
     */
    mapReduce() {
        this.map();
        this.reduce();
        return this.topComment;
    }
}

export {
    Comment
}
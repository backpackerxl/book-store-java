<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:forEach items="${ requestScope.commentList }" var="comment">
    <div class="compents-box">
        <div class="compents-img">
            <img src="<c:url value="${ comment.userCommpment.userImg }"/> ">
        </div>
        <div class="compents-content">
            <p>${ comment.userCommpment.name }</p>
            <p>${ comment.userCommpment.content }</p>
            <p>
                <span><i class="fa fa-calendar-minus-o"></i>${ comment.userCommpment.createTime }</span>
                <c:if test="${ comment.userCommentList != null }">
                    <b id="more-compents">— 展开${ comment.userCommentList.size() }条回复 <i
                            class="fa fa-caret-down"></i></b>
                </c:if>
                <a onclick="toReplay(this, '${ comment.userCommpment.id }', '${ comment.userCommpment.name }')" id="reply-compents" href="javascript:;">回复</a>
            </p>
        </div>
        <c:if test="${ comment.userCommentList != null }">
            <div style="display: none;" id="child-compents">
                <c:forEach items="${ comment.userCommentList }" var="childrenComment">
                    <div class="compents-box">
                        <div class="compents-img">
                            <img src="<c:url value="${ childrenComment.userImg }"/>">
                        </div>
                        <div class="compents-content">
                            <p>${ childrenComment.name }
                                <c:if test="${ childrenComment.parentCommentId != comment.userCommpment.id }">
                                    @ <c:forEach items="${ comment.userCommentList }" var="find_name">
                                    <c:if test="${ find_name.id == childrenComment.parentCommentId }">
                                        <c:out value="${ find_name.name }"/>
                                    </c:if>
                                </c:forEach>
                                </c:if>
                            </p>
                            <p>${ childrenComment.content }</p>
                            <p>
                                        <span><i
                                                class="fa fa-calendar-minus-o"></i>${ childrenComment.createTime }</span>
                                <a onclick="toReplay(this, '${ childrenComment.id }', '${ childrenComment.name }')" id="reply-compents-child"
                                   href="javascript:;">回复</a>
                            </p>
                        </div>
                    </div>
                </c:forEach>
            </div>
        </c:if>
    </div>
</c:forEach>

<script src="<c:url value="/js/replay.js" />"></script>

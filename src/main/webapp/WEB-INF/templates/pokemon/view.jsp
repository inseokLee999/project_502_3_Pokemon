<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="fn" uri="jakarta.tags.functions" %>
<%@ taglib prefix="fmt" uri="jakarta.tags.fmt" %>
<%@ taglib prefix="layout" tagdir="/WEB-INF/tags/layouts" %>
<fmt:setBundle basename="messages.commons" />
<c:url var="pokemonUrl" value="/pokemon" />
<layout:main title="${data.nameKr}(${data.name})">

    <section class="pokemon-view">
        <img src="${data.frontImage}" alt="프론트" class="pokemon-view-img">
        <img src="${data.backImage}" alt="백" class="pokemon-view-img">
        <div class="p-desc">
            <div class="p-name">
                <h2>
                        ${data.nameKr}(${data.name}) <fmt:message key="도감번호"/> : ${data.seq}
                </h2>
            </div>
            <div class="p-spec-km">
                <div class="p-spec-item"> <h4><fmt:message key="포켓몬_번호"/> : ${data.seq}</h4></div>
            <div class="p-spec-item"> <h4><fmt:message key="무게"/> : ${data.weight*0.1} kg </h4></div>
            <div class="p-spec-item"> <h4><fmt:message key="높이"/> : ${data.height*0.1} m </h4></div>
            <div class="p-spec-item"><h4><fmt:message key="초기경험치"/> : ${data.baseExperience}</h4></div>
            </div>
            <div class="p-desc">
                <h3>${fn:replace(data.description, '\\n', '<br>')}</h3>
            </div>
            <div class="p-type">
                <div class="type1" >
                        <fmt:message key="타입1"/> : ${data.type1}
                </div>
                <c:if test="${data.type2!=null}">
                    <div class="type2">
                        /<fmt:message key="타입2"/> : ${data.type2}
                    </div>
                </c:if>
            </div>
            참고 주소 : <a href='https://pokeapi.co/api/v2/pokemon/${data.seq}' target="_blank">https://pokeapi.co/api/v2/pokemon/${data.seq}</a>
            <br><br><br>
            <div class="centered">
                <a href="<c:url value="/..${pokemonUrl}"/>" class="button button-secondary">포켓몬도감</a>
            </div>
        </div>
        <br><br><br>


            <%--            ${data.pokemon}--%>
    </section>
    <script src="../js/pokemon/view.js"></script>
</layout:main>
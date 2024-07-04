<%@ page import="org.choongang.pokemon.entities.PokemonDetail" %>
<%@ page import="org.choongang.pokemon.entities.api.Pokemon" %>
<%@ page import="java.text.DecimalFormat" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="fn" uri="jakarta.tags.functions" %>
<%@ taglib prefix="fmt" uri="jakarta.tags.fmt" %>
<%@ taglib prefix="layout" tagdir="/WEB-INF/tags/layouts" %>
<fmt:setBundle basename="messages.commons"/>
<c:url var="pokemonUrl" value="/pokemon"/>
<%
    PokemonDetail pokemonDetail = (PokemonDetail) request.getAttribute("data");
    DecimalFormat df = new DecimalFormat("#.0");
    float weight = Float.parseFloat(df.format(pokemonDetail.getWeight() * 0.1));
    float height = Float.parseFloat(df.format(pokemonDetail.getHeight() * 0.1));
    session.setAttribute("weight", weight);
    session.setAttribute("height", height);
%>
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
                <div class="p-spec-item"><h4><fmt:message key="포켓몬_번호"/> : ${data.seq}</h4></div>
                <div class="p-spec-item"><h4><fmt:message key="무게"/> : ${weight} kg </h4></div>
                <div class="p-spec-item"><h4><fmt:message key="높이"/> : ${height} m </h4></div>
                <div class="p-spec-item"><h4><fmt:message key="초기경험치"/> : ${data.baseExperience}</h4></div>
            </div>
            <div class="p-type">
                <span class="badge badge-${data.type1}">
                        <fmt:message key="${data.type1}"/>
                </span>
                <c:if test="${data.type2!=null}">
                    /
                    <span class="badge badge-${data.type2}">
                         <fmt:message key="${data.type2}"/>
                    </span>
                </c:if>
            </div>
            <div class="p-desc">
                <h3>${fn:replace(data.description, '\\n', '<br>')}</h3>
            </div>
            참고 주소 : <a href='https://www.pokemonkorea.co.kr/pokedex/view/${data.seq}' target="_blank">https://www.pokemonkorea.co.kr/pokedex/view/${data.seq}</a>
            <br><br><br>
            <div class="forward">
                <div class="centered-left">
                    <a href="<c:url value="/..${pokemonUrl}/${data.seq-1}"/>" class="button button-primary">이전 포켓몬</a>
                </div>
                <div class="centered">
                    <a href="<c:url value="/..${pokemonUrl}"/>" class="button button-secondary">포켓몬 도감</a>
                </div>
                <div class="centered-right">
                    <a href="<c:url value="/..${pokemonUrl}/${data.seq+1}"/>" class="button button-primary">다음 포켓몬</a>
                </div>
            </div>
        </div>
        <br><br><br>


            <%--            ${data.pokemon}--%>
    </section>
    <script src="../js/pokemon/view.js"></script>
</layout:main>
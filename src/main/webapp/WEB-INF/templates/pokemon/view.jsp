<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="fn" uri="jakarta.tags.functions" %>
<%@ taglib prefix="layout" tagdir="/WEB-INF/tags/layouts" %>
<layout:main title="${data.nameKr}(${data.name})">
    <section class="pokemon-view">
        <img src="${data.frontImage}" alt="프론트">
        <img src="${data.backImage}" alt="백">
        <div class="p-desc">
            <div class="p-name">
                <h2>
                        ${data.nameKr}(${data.name})
                </h2>
            </div>
            <div class="p-desc">
                <h3>${fn:replace(data.description, '\\n', '<br>')}</h3>
            </div>
            참고 주소 : <a href='https://pokeapi.co/api/v2/pokemon/${data.seq}' target="_blank">https://pokeapi.co/api/v2/pokemon/${data.seq}</a>
        </div>

        <br><br><br>
<%--            ${data.pokemon}--%>
    </section>
</layout:main>
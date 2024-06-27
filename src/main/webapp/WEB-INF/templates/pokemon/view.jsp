<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="fn" uri="jakarta.tags.functions" %>
<%@ taglib prefix="layout" tagdir="/WEB-INF/tags/layouts" %>
<layout:main title="${data.nameKr}(${data.name})">
    <section class="pokemon-view">
        <img src="${data.frontImage}" alt="프론트">
        <img src="${data.backImage}" alt="백">
        <div class="p-name">
                ${data.nameKr}(${data.name})
        </div>
        <div class="p-desc">
                ${fn:replace(data.description,'\n' ,'<br>')}
        </div>
        참고 주소 : <a href="https://pokeapi.co/api/v2/pokemon/${data.seq}" target="_blank">
            ${data.pokemon}</a>
    </section>
</layout:main>
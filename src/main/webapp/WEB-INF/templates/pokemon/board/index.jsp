<%@page contentType="text/html; charset=UTF-8" %>
<%@taglib prefix="layout" tagdir="/WEB-INF/tags/layouts" %>
<%@taglib prefix="c" uri="jakarta.tags.core" %>
<%@taglib prefix="fmt" uri="jakarta.tags.fmt" %>
<fmt:setBundle basename="messages.commons"/>
<c:set var="addCss" value="/pokemon"/>
<layout:main title="포켓몬_도감">
    <jsp:body>
        <section class="layout-width content-box">
            <ul class="row list-book" id="pokedexlist">
                <li id="pokedex_1">
                    <a href="#" class="pokemon">
                        <div class="img">
                            <div class="tumb-wrp">
                                <img src="images/pokemon/1.png" alt="포켓몬1">
                            </div>
                        </div>
                        <div class="bx-txt">
                            <h3>
                                <p>No.0001</p>
                                "이상해 씨"
                            </h3>
                            <p></p>
                            <span>풀</span>
                            <span>독</span>
                        </div>
                    </a>
                </li>
                <li id="pokedex_2">
                    <a href="#" class="pokemon">
                        <div class="img">
                            <div class="tumb-wrp">
                                <img src="images/pokemon/2.png" alt="포켓몬1">
                            </div>
                        </div>
                        <div class="bx-txt">
                            <h3>
                                <p>No.0001</p>
                                "이상해 씨"
                            </h3>
                            <p></p>
                            <span>풀</span>
                            <span>독</span>
                        </div>
                    </a>
                </li><li id="pokedex_3">
                <a href="#" class="pokemon">
                    <div class="img">
                        <div class="tumb-wrp">
                            <img src="images/pokemon/3.png" alt="포켓몬1">
                        </div>
                    </div>
                    <div class="bx-txt">
                        <h3>
                            <p>No.0001</p>
                            "이상해 씨"
                        </h3>
                        <p></p>
                        <span>풀</span>
                        <span>독</span>
                    </div>
                </a>
            </li><li id="pokedex_4">
                <a href="#" class="pokemon">
                    <div class="img">
                        <div class="tumb-wrp">
                            <img src="images/pokemon/subin.png" alt="포켓몬1">
                        </div>
                    </div>
                    <div class="bx-txt">
                        <h3>
                            <p>No.0001</p>
                            "이상해 씨"
                        </h3>
                        <p></p>
                        <span>풀</span>
                        <span>독</span>
                    </div>
                </a>
            </li><li id="pokedex_5">
                <a href="#" class="pokemon">
                    <div class="img">
                        <div class="tumb-wrp">
                            <img src="images/pokemon/ramos.png" alt="포켓몬1">
                        </div>
                    </div>
                    <div class="bx-txt">
                        <h3>
                            <p>No.0001</p>
                            "이상해 씨"
                        </h3>
                        <p></p>
                        <span>풀</span>
                        <span>독</span>
                    </div>
                </a>
            </li>
            </ul>
        </section>
    </jsp:body>

</layout:main>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css"
          integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous">
    <script src="https://cdnjs.cloudflare.com/ajax/libs/turbolinks/5.2.0/turbolinks.js"></script>
    <script defer="defer" src="https://code.jquery.com/jquery-3.5.1.slim.min.js"
            integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
</head>
<body>
<nav class="navbar navbar-light bg-light">
    <div class="container-fluid">
        <a class="navbar-brand" href="/index">NotePad</a>

            <div class="container">

            </div>

            <form class="form-inline my-2 my-lg-0" method="post" action="/searchNote">
                <label class="form-check-label m-2">
                    Search in
                </label>
                <div class="form-check m-2">
                    <input class="form-check-input" type="radio" name="radio" id="Radio1" value="title">
                    <label class="form-check-label" for="Radio1">
                       title
                    </label>
                </div>
                <div class="form-check m-2">
                    <input class="form-check-input" type="radio" name="radio" id="Radio2" value="text" checked>
                    <label class="form-check-label" for="Radio2">
                        text
                    </label>
                </div>
                <input class="form-control me-2" type="search" placeholder="Search" aria-label="Search" name="search">
                <button class="btn btn-outline-success m-2" type="submit">Search</button>
            </form>
    </div>
</nav>

<div class="container">
<form method="post" action="/addNote" enctype="multipart/form-data">
    <div class="row m-5">
        <div class="col">
            <input type="text" class="form-control" placeholder="Title" name="title">
        </div>
        <div class="col">
            <input type="text" class="form-control" placeholder="Text" name="text">
        </div>
        <div class="d-grid gap-2 d-md-flex justify-content-md-end">
            <button class="btn btn-primary ml-2" type="submit">Add</button>
        </div>
    </div>
</form>
</div>

<div class="container">

    <div class="container m-3">
        <div class="row">
<#list noteDomains as note>

            <div class="col-sm-3 col-md-4">
    <div class="card border-dark mb-3 col-12" style="max-width: 30rem;">
        <div class="card-body">
            <h5 class="card-title fs-2">${note.title}</h5>
            <p class="card-text">${note.text}</p>

            <div class="d-grid gap-2 d-md-flex justify-content-md-end">

                <form method="get" action="/deleteNote/${note.id}" enctype="multipart/form-data">
                    <button type="submit" class="btn btn-danger ml-2 mr-2">Delete</button></form>
                <p>
                <a class="btn btn-primary mb-1" data-toggle="collapse" href="#collapseExample${note.id}"
                   role="button" aria-expanded="false" aria-controls="collapseExample${note.id}">
                    Edite
                </a>
                <p>
                <div class="collapse" id="collapseExample${note.id}">
                    <div class="card card-body">
                        <form method="post" action="/updateNote" enctype="multipart/form-data">

                            <div class="form-group">
                                <input type="hidden" name="id" value="${note.id}">
                                <input type="text" class="form-control " name="title" value="${note.title}">
                            </div>
                                <div class="form-group m-1">
                                <textarea type="text" class="form-control" name="text" value="${note.text}">${note.text}</textarea>
                                </div>
                                <div class="form-group m-1">
                                <button type="submit" class="btn btn-primary">Save</button>
                                </div>
                        </form>
                    </div>
                </div>
        </div>
        </div>
    </div>
    </div>

</#list>
        </div>
    </div>
</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-ho+j7jyWK8fNQe+A12Hb8AhRq26LrZ/JpcUGGOn+Y7RsweNrtN/tE3MoK7ZeZDyx" crossorigin="anonymous"></script>
</body>
</html>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Calculate inhabitants</title>
</head>
<body>
<form>
    <fieldset>
        <input type="text" name="name" placeholder="Name"><br>
        <input type="number" name="year" placeholder="Year"><br>
        <button type="submit">Save</button>
    </fieldset>
</form>
<script>
    (function () {
        var form = document.querySelector('form')
        form.addEventListener('submit', function (e) {
            e.preventDefault()
            var name = form.querySelector('input[name=name]').value
            var year = form.querySelector('input[name=year]').value

            if (!(name === null || name === undefined || name.length === 0 ||
                year === null || year === undefined || year.length === 0))
                window.location.href = encodeURI('/rest/DistrictService/districts/' + name + '/' + year)
        })
    })()
</script>
</body>
</html>

$(document).ready(function () {
    $('.open-modal').click(function () {
        $.ajax({
            url: '/rating',
            type: 'GET',
            dataType: 'json',
            data: {
                teacherId: $(this).data('teacher-id')
            },
            success: function (data) {
                var firstName = data.teacher.firstName || "";
                var lastName = data.teacher.lastName || "";
                var patronymic = data.teacher.patronymic || "";
                var description = data.teacher.description || "";
                var imagePath = '/img/' +  data.teacher.imagePath || "/img/defaultImage.jpg";
                var value = data.value;

                $('.popup > .card > .card-right').html( lastName + " <br>" + firstName +
                    " <br>" + patronymic + " <br> <h4 class=\"undertitle\">" +
                    description + "</h4>");
                $('.popup > .card > .card-left > .logo > img').attr('src', imagePath);
                $("input[name=teacherId]").val(data.teacher.id);
                if (value !== null) {
                    $("input[name=rate][value=" + value + "]").prop('checked', true);
                } else {
                    $("input[name=rate]").prop('checked', false);

                }
            }
        });
    });

    $('#teacher-rate').submit(function (e) {
        $.ajax({
            type: 'POST',
            url: '/vote',
            data: $('#teacher-rate').serialize(),
            success: function (data) {
                $('#close-button')[0].click();
            }
        });
        e.preventDefault();
    });
});
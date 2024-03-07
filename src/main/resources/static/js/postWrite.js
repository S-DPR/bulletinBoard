window.addEventListener('load', () => {
    const id = document.querySelector('#id')
    const submitBtn = document.querySelector('#submitBtn')
    const title = document.querySelector('#title')
    const content = document.querySelector('#content')
    submitBtn.addEventListener('click', () => {
        const reqType = id.value !== "" ? REQUEST_TYPE.PATCH : REQUEST_TYPE.POST
        requestFn(reqType, '/', {
            id: id.value,
            title: title.value,
            content: content.value,
        }, () => {
            console.log("Success")
        })
    })
})

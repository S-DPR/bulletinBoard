window.addEventListener('load', () => {
    const postId = document.querySelector('#id').value
    const mainBtn = document.querySelector('#mainBtn')
    const editBtn = document.querySelector('#editBtn')
    const delBtn = document.querySelector('#delBtn')

    editBtn.hidden = false
    delBtn.hidden = false

    mainBtn.addEventListener('click', () => {
        location.href = `/`
    })
    editBtn.addEventListener('click', () => {
        location.href = `/postWrite/${postId}`
    })
    delBtn.addEventListener('click', () => {
        requestFn(REQUEST_TYPE.DELETE, `/post/${postId}`, null, () => {
            location.href = `/`
        })
    })
})
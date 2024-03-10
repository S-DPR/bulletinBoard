window.addEventListener('load', () => {
    const postId = document.querySelector('#id').value
    const mainBtn = document.querySelector('#mainBtn')
    const editBtn = document.querySelector('#editBtn')
    const delBtn = document.querySelector('#delBtn')

    mainBtn.addEventListener('click', () => {
        location.href = `/`
    })
    if (editBtn) {
        editBtn.addEventListener('click', () => {
            location.href = `/postWrite/${postId}`
        })
    }
    if (delBtn) {
        delBtn.addEventListener('click', () => {
            requestFn(REQUEST_TYPE.DELETE, `/sys/post/${postId}`, null, () => {
                location.href = `/`
            })
        })
    }
})
